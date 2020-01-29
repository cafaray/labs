object MyApp extends App {
    //var names = Seq("alberto","sonia","maria jose", "ana sofia")
    //val names2 = for (e <- names) yield e.capitalize
    //val names2 = names.map(_.capitalize)
    //for (n <- names2) println(n)
    /*
    for ((name,count) <- names.view.zip(Stream from 1)) {
        println(s"$count is $name")
    }
    
    names.zipWithIndex.foreach { d =>
        println(s"${d._2} is ${d._1}")
    }
    */
    val nameMap = Map("firstName" -> "Edmond", "lastName" -> "Syd")
    val result = for ((k,v) <- nameMap) yield {
        s"key: $k, value: $v"
    }
    println(result)
}
