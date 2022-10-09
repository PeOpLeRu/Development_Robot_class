import kotlin.math.abs

fun moveRobot(r: Robot, toX: Int, toY: Int) : Int
{
    var totalSteps = 0
    var dX = toX - r.x
    var dY = toY - r.y

    if (dX > 0)
    {
        while (r.direction != Direction.RIGHT)
        {
            if (Direction.RIGHT.ordinal - r.direction.ordinal > 0) r.turnRight() else r.turnLeft()
        }
    }
    else if (dX < 0)
    {
        while (r.direction != Direction.LEFT)
        {
            if ((Direction.LEFT.ordinal - r.direction.ordinal > 0) && (Direction.LEFT.ordinal - r.direction.ordinal <= 2)) r.turnRight() else r.turnLeft()
        }
    }

    dX = abs(dX)
    totalSteps += dX
    while (dX != 0)
    {
        r.stepForward()
        dX -= 1
    }

    if (dY > 0)
    {
        while (r.direction != Direction.UP)
        {
            if (r.direction.ordinal - Direction.UP.ordinal >= 2) r.turnRight() else r.turnLeft()
        }
    }
    else if (dY < 0)
    {
        while (r.direction != Direction.DOWN)
        {
            if (Direction.DOWN.ordinal - r.direction.ordinal > 0) r.turnRight() else r.turnLeft()
        }
    }

    dY = abs(dY)
    totalSteps += dY
    while (dY != 0)
    {
        r.stepForward()
        dY -= 1
    }

    return totalSteps
}

fun main()
{
    val robot = Robot(150, -1, Direction.UP)

    println(robot)

    println("Steps: ${moveRobot(robot, -100, 201)}")

    println(robot)
}