<?php

namespace App\Http\Controllers\api;

use App\Entities\Account;
use App\Entities\DepositAccount;
use App\Entities\TransferAccount;
use App\Entities\WithdrawAccount;
use App\Http\Controllers\Controller;
use App\Interfaces\AccountInterface;
use App\Interfaces\HandlerInterface;
use Illuminate\Http\Request;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Response;
use Illuminate\Support\Facades\Cache;
use Illuminate\Support\Facades\Log;

class BankController extends Controller
{
    private Account $account;

    public function __construct(Account $account)
    {
        $this->account = $account;
    }

    public function reset()
    {
        Cache::flush();
        return response("OK");
    }

    public function getAccount(Request $request)
    {
        if (!Cache::has('account')){
            Log::channel('bankTransition')->info([json_encode(["input" => $request->all()]), json_encode(["response" => null])]);
            return response()->json(0, Response::HTTP_NOT_FOUND);
        }

        Log::channel('bankTransition')->info([json_encode(["input" => $request->all()]), json_encode(["response" => Cache::get('account')])]);
        return response(Cache::get('account')->balance, Response::HTTP_OK);
    }

    public function getEventAccount(Request $request)
    {
        $deposit  = new DepositAccount();
        $tranfer  = new TransferAccount();
        $withdraw = new WithdrawAccount();

        $deposit->setNext($tranfer)->setNext($withdraw);
        return $this->account->clientCode($deposit, $request);
    }
}
