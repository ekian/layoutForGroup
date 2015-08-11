/**
 * Created by Administrator on 2015/8/10.
 */
class Layout {
  def layout(parentWidth: Double, padding: Double, vSpacing: Double, hSpacing: Double, children: Seq[Size]): Seq[Point]={
    children.foreach(child =>
      require(child.width < parentWidth-2*padding)
    )
//    var point = Point(0.0,0.0)
    var pointX = padding
    var pointY = padding
    val leftWidth = parentWidth-2*padding
    var height = 0.0
    //初始布局
    val initLayout = children.flatMap{child=>
      if(child.height>height)
        height = child.height
      if(pointX+child.width >leftWidth){
        pointY += height + vSpacing
        pointX = padding
      }

      val point = Point(pointX,pointY)
      pointX += child.width + hSpacing
      Seq((child,point))
    }
    //最终布局，根据最高的矩形居中
    initLayout.groupBy(_._2.y).flatMap{i=>
      val layouts = i._2
      if(layouts.size==1)
        Seq(layouts.head._2)
      else{
        val maxHeight = layouts.map(_._1.height).max
        layouts.flatMap{l=>
          val y = (maxHeight-l._1.height)/2
          Seq(Point(l._2.x,l._2.y+y))
        }
      }
    }.toSeq

//    initLayout.map(_._2).foreach(println)initLayout.map(_._2)

  }
//  layout(parentWidth = 10.0, padding = 1.0, vSpacing = 1.0, hSpacing = 0, Seq(Size(5, 7), Size(5, 5)))
}

  case class Size(width: Double, height: Double)
  case class Point(x: Double, y: Double)

