<?php

namespace App\Interfaces;

interface HandlerInterface
{
    public function setNext(HandlerInterface $handler): HandlerInterface;

    public function handle(object $request, object $account): ?object;
}
