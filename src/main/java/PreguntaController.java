import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
@CrossOrigin(origins = "https://nombre-frontend.herokuapp.com") // Cambia esto por la URL de tu frontend.
public class PreguntaController {
    @Autowired
    private PreguntaRepository preguntaRepository;

    @GetMapping
    public List<Pregunta> listarPreguntas() {
        return preguntaRepository.findAll();
    }

    @PostMapping
    public Pregunta agregarPregunta(@RequestBody Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }
}