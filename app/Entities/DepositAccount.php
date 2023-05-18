<?php

namespace App\Entities;

use App\Interfaces\AccountInterface;
use App\Models\Account\AbstractHandler;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Cache;

class DepositAccount extends AbstractHandler
{
    public function handle(object $request, object $account)
    {
        if ($request->type != "deposit")
            return parent::handle($request, $account);

        $account->id      = $request->destination;
        $account->balance = $request->amount;

        if(Cache::has('account')){
            if($account->destination == Cache::get('account')->destination){
                $account->balance = $request->amount + Cache::get('account')->balance;
                $key = Cache::get('account');
                $key->balance = $account->balance ;
                Cache::put('account', $key);
            }
        }else{
            Cache::remember('account', 1440, function () use ($account) {
                return $account;
            });
        }

        $response =  array(
            "destination"=> array(
               "id"      => $account->id,
               "balance" => $account->balance
            )
        );

        return response()->json( $response, Response::HTTP_CREATED);
    }
}
