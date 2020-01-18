package com.psawesome.obstacle

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.health.AbstractHealthIndicator
import org.springframework.boot.actuate.health.Health
import org.springframework.stereotype.Component

/**
package: com.psawesome.obstacle
author: PS
DATE: 2020-01-18 토요일 17:16
 */
@Component
class ObstacleServiceHealthIndicator : AbstractHealthIndicator() {
    @Autowired
    lateinit var obstacleService: ObstacleService

    override fun doHealthCheck(builder: Health.Builder) {
        val lastMessage = try {
            val message = obstacleService.getObstacle()
            builder.up()
            message
        } catch (exception: Exception) {
            builder.down()
            "Error:$exception"
        }

        builder.withDetail("lastMessage", lastMessage)
    }
}