<?php

namespace App\Models\Account;

use App\Interfaces\HandlerInterface;

abstract class AbstractHandler implements HandlerInterface
{
    /**
     * @var HandlerInterface
     */
    private $nextHandler;

    public function setNext(HandlerInterface $handler): HandlerInterface
    {
        $this->nextHandler = $handler;
        return $handler;
    }

    public function handle(object $request, object $account)
    {
        if ($this->nextHandler) {
            return $this->nextHandler->handle($request, $account);
        }

        return null;
    }
}
