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
        $this->account->balance     = 0;
        $this->account->id          = 0;
    }

    function clientCode(HandlerInterface $handler, $request)
    {
        $request = (object) $request;
        return $handler->handle($request, $this->account);
    }
}
