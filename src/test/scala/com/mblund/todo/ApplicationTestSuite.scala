package com.mblund.todo

import com.mblund.todo.domain._
import com.mblund.todo.technology.{Subscriber, Command, Topic}
import utest.{assert, _}

import scala.collection.mutable


object ApplicationTestSuite extends TestSuite {
  val tests = TestSuite{
    'test2{

      implicit val eventsTopic = new Topic[TodoEvent]
      val events = new mutable.MutableList[TodoEvent]()

      eventsTopic.subscribe(new Subscriber[TodoEvent] {
        override def receive: PartialFunction[TodoEvent, Unit] = {
          case Reset=> events.clear()
          case event:TodoEvent=> events += event }
      })

      val app = new TodoApplication
      app.run(AddTodoList)
      app.run(AddTodoList)
      app.run(AddTodo(1,"Fodo1"))
      app.run(Undo)
      app.run(AddTodo(1,"Todo"))
      assert(events.size ==3)

    }
  }
}