<?php

namespace App\Interfaces;

interface AccountRepositoryInterface
{
    public function deposit(String $destination, int $amount);
    public function withdraw(String $origin, int $amount);
    public function transfer(String $origin, int $amount, String $destination);
}
