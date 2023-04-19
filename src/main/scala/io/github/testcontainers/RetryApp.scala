package io.github.testcontainers

import scala.annotation.tailrec

object RetryApp extends App {
    var trial = 1
    retryPolling(5)

    @tailrec
    def retryPolling(n: Int): Unit = {
        println(s"Trial: $trial     Retry: $n")
        Thread.sleep(1000)
        if (!getValue(trial) && n > 1) then
            trial = trial + 1
            retryPolling(n - 1)
        else if(n == 1) then
            println(s"Retry limit exceeded. Maximum $trial retries allowed.")

    }

    private def getValue(retry: Int): Boolean = {
        val res = {
            if retry == 7 then
                println("Yayy!!")
                true
            else
                println("Need to retry...")
                false
        }
        res
    }

}
