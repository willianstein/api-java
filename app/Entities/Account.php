<?php

namespace App\Entities;

use App\Interfaces\AccountInterface;
use App\Interfaces\HandlerInterface;
use stdClass;
use Psy\Util\Json;

class Account
{
    private stdClass $account;

    public function __construct()
    {
        $this->account              = new stdClass;
        $this->account->type        = null;
        $this->account->destination = 0;
        $this->account->balance     = 0;
        $this->account->amount      = 0;
        $this->account->origin      = 0;
        $this->account->id          = 0;
    }

    public function getAccount(int $id)
    {

        if ($id != 100)
            return $this->account->id;
    }

    public function getEventAccount($request)
    {

        dd($request);
    }

    function clientCode(HandlerInterface $handler, $request)
    {
        $request = (object) $request;
        return $handler->handle($request, $this->account);
    }
}
