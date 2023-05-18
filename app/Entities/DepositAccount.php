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
            return parent::handle($request);

        $account->id      = $request->destination;
        $account->balance = $request->amount;

        if(Cache::has('deposit')){
            if($account->destination == Cache::get('deposit')->destination){
                $account->balance = $request->amount + Cache::get('deposit')->balance;
            }
        }else{
            Cache::remember('deposit', 1440, function () use ($account) {
                return $account;
            });
        }

        return array(
            "destination"=> array(
               "id"      => $account->id,
               "balance" => $account->balance
            )
        );
    }
}
