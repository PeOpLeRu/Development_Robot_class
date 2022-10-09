enum class Direction
{
    UP, RIGHT, DOWN, LEFT
}

class Robot(var x: Int, var y: Int, var direction: Direction) {
    fun stepForward()
    {
        when (direction) {
            Direction.RIGHT -> x++
            Direction.LEFT -> x--
            Direction.UP -> y++
            Direction.DOWN -> y--
        }
    }

    fun turnLeft()
    {
        var nowDirection = direction.ordinal
        nowDirection = if (nowDirection == 0) Direction.values().size - 1 else nowDirection - 1
        direction = Direction.values()[nowDirection]
    }

    fun turnRight()
    {
        var nowDirection = direction.ordinal
        nowDirection = if (nowDirection == Direction.values().size - 1) 0 else nowDirection + 1
        direction = Direction.values()[nowDirection]
    }

    override fun toString(): String
    {
        return "(x:${x}, y:${y}) <-----> direction: ${direction.toString()}"
    }
}