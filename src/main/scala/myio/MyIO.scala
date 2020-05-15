package myio
import cats.effect.IO

import scala.util.Random

class MyIO {

}

object MyIO{
  def main(args: Array[String]): Unit ={
    val ioa = IO {
      var i =0;
      while(true){
        Thread.sleep(450)
        println("A: "+i)
        i+=1
      }
    }
    val iob = IO {
      var i =0;
      while(true){
        Thread.sleep(765)
        println("B: "+i)
        i+=1
      }
    }
    val program: IO[Unit] =
      for {
        _ <- ioa.start
        _ <- iob.start
      } yield ()
    program.unsafeRunSync()
    //=> hey!
    //=> hey!
    ()
  }

}
