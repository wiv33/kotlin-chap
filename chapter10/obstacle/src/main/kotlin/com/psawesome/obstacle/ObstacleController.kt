package com.psawesome.obstacle

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
package: com.psawesome.obstacle
author: PS
DATE: 2020-01-18 토요일 15:28
 */
@RestController
class ObstacleController {
    @Autowired
    lateinit var obstacleService: ObstacleService

    @GetMapping("/hello")
    fun message() = obstacleService.getObstacle()
}