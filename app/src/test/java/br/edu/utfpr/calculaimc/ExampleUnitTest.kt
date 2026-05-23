package br.edu.utfpr.calculaimc

import org.junit.Test
import org.junit.Assert.*

/**
 * Testes de unidade para a lógica de cálculo de IMC.
 */
class ExampleUnitTest {

    @Test
    fun calcularImc_metrico_isCorrect() {
        val peso = 80.0
        val altura = 1.80
        val idioma = "pt" // Qualquer coisa diferente de "en"
        
        val resultado = MainActivity.calcularImc(peso, altura, idioma)
        
        // 80 / (1.8 * 1.8) = 24.69135...
        assertEquals("O cálculo do IMC métrico está incorreto", 24.69, resultado, 0.01)
    }

    @Test
    fun calcularImc_imperial_isCorrect() {
        val peso = 150.0 // libras
        val altura = 65.0 // polegadas
        val idioma = "en"
        
        val resultado = MainActivity.calcularImc(peso, altura, idioma)
        
        // 703 * (150 / (65 * 65)) = 24.9585...
        assertEquals("O cálculo do IMC imperial está incorreto", 24.96, resultado, 0.01)
    }

    @Test
    fun calcularImc_valorZero_isCorrect() {
        val resultado = MainActivity.calcularImc(0.0, 1.70, "pt")
        assertEquals("IMC para peso zero deveria ser zero", 0.0, resultado, 0.0)
    }
}
