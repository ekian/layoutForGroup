import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by Administrator on 2015/8/11.
 */
class LayoutSpec extends FlatSpec with Matchers  {
  "Layout" should "Rectangular can be layout correctly" in{
    val layout = new Layout
    layout.layout(parentWidth = 10.0, padding = 1.0, vSpacing = 1.0, hSpacing = 0, Seq(Size(5, 7), Size(5, 5))) should be (Seq(Point(1.0, 1.0), Point(1.0, 9.0)))
  }

}
