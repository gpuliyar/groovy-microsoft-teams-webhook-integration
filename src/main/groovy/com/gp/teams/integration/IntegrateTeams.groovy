package com.gp.teams.integration

import com.mashape.unirest.http.Unirest
import groovy.json.JsonOutput

class IntegrateTeams {
    def connect = { ->
        def url = "<< enter Teams URL >>"
        def text = "Hello World! Hi, From Groovy API Integration!"

        def jsonText = JsonOutput.toJson([text: text])
        def response = Unirest.post(url)
                .header('Content-Type', 'application/json')
                .body(jsonText).asString()

        println "return response from the api call : " +
                "[status : ${response.status}, " +
                "status text : ${response.statusText}, " +
                "and body message : ${response.body}]"
    }

    static void main(String... args) {
        def teams = new IntegrateTeams()
        teams.connect()
    }
}
