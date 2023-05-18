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
       if(!Cache::get('deposit')->id)
        return response($this->account->getAccount($request->input("account_id")), 404);

        return response(Cache::get('balance')->id, Response::HTTP_OK);
    }

    public function getEventAccount(Request $request)
    {
        $deposit  = new DepositAccount();
        $tranfer  = new TransferAccount();
        $withdraw = new WithdrawAccount();

        $deposit->setNext($tranfer)->setNext($withdraw);
        $result =   $this->account->clientCode($deposit, $request);

        return response()->json($result, Response::HTTP_CREATED);
    }

}
