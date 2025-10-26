package br.com.fiap;

import com.intuit.karate.junit5.Karate;

class EducaFinRunnerTest {

    @Karate.Test
    Karate runAll() {
        return Karate.run("classpath:features/educafin.feature");
    }
}
