/*
 * Copyright 2018 Thunderberry.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.altindag.client.service

import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java
import nl.altindag.client.ClientType
import nl.altindag.client.ClientType.KTOR_JAVA_HTTP_CLIENT
import nl.altindag.ssl.SSLFactory
import org.springframework.stereotype.Service

@Service
class KtorJavaHttpClientService(
    sslFactory: SSLFactory
) : KtorHttpClientService(
    HttpClient(Java) {
        engine {
            config {
                sslContext(sslFactory.sslContext)
                sslParameters(sslFactory.sslParameters)
            }
        }
    }
) {

    override fun getClientType(): ClientType = KTOR_JAVA_HTTP_CLIENT

}
