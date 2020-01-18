package com.psawesome.obstacle

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.*

/**
package: com.psawesome.obstacle
author: PS
DATE: 2020-01-18 토요일 15:25
 */
@Service
class ObstacleServiceImpl: ObstacleService {
    companion object {
        private val obstacleMessage = arrayOf("Hello", "Webflux", "Mono", "Flux")
    }
    fun userRandom(max: Int) = Random().nextInt(max) + 1

    override fun getObstacle(): Mono<String> = Mono.just(obstacleMessage[userRandom(4)])

}