<?php

use App\Http\Controllers\api\BankController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/
Route::get('/', function () {
    return view('welcome');
});

Route::post('reset',  [BankController::class, 'reset']);
Route::get('balance', [BankController::class, 'getAccount']);
Route::post('event',  [BankController::class, 'getEventAccount']);

// Route::post('/category/{category}', function (string $category) {
//     // ...
// })->whereIn('category', ['movie', 'song', 'painting']);
