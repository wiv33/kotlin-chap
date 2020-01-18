package com.psawesome.obstacle

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jmx.export.annotation.ManagedOperation
import org.springframework.jmx.export.annotation.ManagedOperationParameter
import org.springframework.jmx.export.annotation.ManagedOperationParameters
import org.springframework.jmx.export.annotation.ManagedResource
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

/**
package: com.psawesome.obstacle
author: PS
DATE: 2020-01-18 토요일 17:31
 */
@Component
@ManagedResource(objectName = "com.psawesome:type=obstacle,name=GetHello", description = "Get Obstacle")
class ObstacleMBean {

    @Autowired
    lateinit var obstacleService: ObstacleService

    @ManagedOperation(description = "Returns a obstacle message")
    @ManagedOperationParameters(ManagedOperationParameter(description = "provide a name", name = "name"))
    fun hello(name: String) = try {
        obstacleService.getObstacle().block() + " $name!"
    } catch (exception: Exception) {
        "oh $name, we get an error: $exception"
    }
}