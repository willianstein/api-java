<?php

namespace App\Entities;

use App\Models\Account\AbstractHandler;
use stdClass;
use Psy\Util\Json;

class TransferAccount extends AbstractHandler
{
    public function handle(object $request, object $account): ?object
    {
        if ($request->type != "tranfer")
           return parent::handle($request);

        dd('tranfer');
    }
}
