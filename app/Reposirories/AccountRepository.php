<?php

namespace App\Repositories;

use App\Interfaces\AccountRepositoryInterface;
use App\Models\Order;

class AccountRepository implements AccountRepositoryInterface
{

    public function deposit(String $destination, int $amount){

    }

    public function withdraw(String $origin, int $amount){

    }

    public function transfer(String $origin, int $amount, String $destination){

    }
}
