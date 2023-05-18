<?php

namespace App\Entities;

use App\Models\Account\AbstractHandler;
use Illuminate\Support\Facades\Cache;
use Illuminate\Http\Response;
use stdClass;
use Psy\Util\Json;

class TransferAccount extends AbstractHandler
{
    public function handle(object $request, object $account)
    {
        if ($request->type != "transfer")
            return parent::handle($request, $account);

        $cache = Cache::get('account');

        if ($cache->id == $request->origin && $cache->balance >= $request->amount) {
            $key = $cache;
            $key->balance -= $request->amount;
            Cache::put('account', $key);

            $response =  array(
                "origin" => array(
                    "id"      => $cache->id,
                    "balance" => $cache->balance
                ),
                "destination" => array(
                    "id"      => $request->destination,
                    "balance" => $request->amount
                )
            );
            return response()->json($response, Response::HTTP_CREATED);
        }

        return response()->json(0, Response::HTTP_NOT_FOUND);
    }
}
