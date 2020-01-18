package com.psawesome.obstacle

import reactor.core.publisher.Mono

/**
package: com.psawesome.obstacle
author: PS
DATE: 2020-01-18 토요일 15:25
 */
interface ObstacleService {
    fun getObstacle(): Mono<String>
}