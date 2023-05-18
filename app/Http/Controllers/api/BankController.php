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

class BankController extends Controller
{
    private Account $account;

    public function __construct(Account $account)
    {
        $this->account = $account;
    }

    public function reset()
    {
        return response("OK");
    }

    public function getAccount(Request $request)
    {
        return response($this->account->getAccount($request->input("account_id")), 200);
    }

    public function getEventAccount(Request $request)
    {
        $deposit  = new DepositAccount();
        $tranfer  = new TransferAccount();
        $withdraw = new WithdrawAccount();

        $deposit->setNext($tranfer)->setNext($withdraw);

        $this->account->clientCode($deposit, $request);




        // $result = $handler->handle($squirrel);

        // dd($result);

        // $this->account->getAccount($request->input("account_id")), 200);

        // $monkey   = new DepositAccount($request->all());
        // $squirrel = new TransferAccount($request->all());
        // $dog      = new WithdrawAccount($request->all());

        // $monkey->setNext($squirrel)->setNext($dog);

    //    dd(getEventAccount($monkey));
        // return response($this->accountRepository->getEventAccount($request->all()));
    }

}
