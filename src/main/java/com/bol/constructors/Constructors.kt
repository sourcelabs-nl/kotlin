package com.bol.constructors

/**
 * Constructors can have default values and the keyword val/var defines whether or not the properties are
 * mutable.
 */
class ServerConfig(
        val hostname: String,
        var port: Int = 80
)

/**
 * Example of a few ways to construct a new instance of an object.
 *
 * Notice the usage of default and named paramters
 */
fun main(args: Array<String>) {
    // Instantiate with only the one required parameter
    val serverConfig = ServerConfig("127.0.0.1")

    // Instantiate with both
    val serverConfig2 = ServerConfig("127.0.0.1", 4444)

    // Instantiate with named parameter, notice the ordering doesn't have to match.
    val serverConfig3 = ServerConfig(port = 4444, hostname = "127.0.0.1")

    // We can change the port for the serverconfig as it is marked as a mutable variable ('var')
    serverConfig.port = 1000
}
