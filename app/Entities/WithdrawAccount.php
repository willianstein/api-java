<?php

namespace App\Entities;

use App\Interfaces\AccountInterface;
use App\Models\Account\AbstractHandler;
use stdClass;
use Psy\Util\Json;

class WithdrawAccount extends AbstractHandler
{
    public function handle(object $request, object $account): ?object
    {
        if ($request->type != "withdraw")
            return parent::handle($request);

     dd('withdraw');
    }
}
