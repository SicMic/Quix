package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Quiz;
import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.repository.RaccoltaRepository;

//classe per definire le operazioni CRUD tramite metodi java: descrive i servizi offerti
@Service
public class RaccoltaService {
	
	@Autowired private RaccoltaRepository raccoltaRepository;	//istanza costruita e inizializzata dal framework

	@Autowired private EtichettaService etichettaService;

    public Raccolta getRaccoltaById(Long id) {
        return this.raccoltaRepository.findById(id).get();
    }

	public Iterable<Raccolta> getAllRaccolte(){
		return this.raccoltaRepository.findAll();
	}

	public Iterable<Raccolta> getRaccoltaByEtichetta(Long etichettaId){
		return this.raccoltaRepository.findByEtichettaId(etichettaId);
	}

	public Iterable<Raccolta> getRaccoltaByEtichettaAndAutore(Long autoreId, Long etichettaId){
		return this.raccoltaRepository.findByAutoreIdAndEtichettaId(autoreId, etichettaId);
	}

	public Iterable<Raccolta> getRaccoltaByEtichettaNomeAndAutore(Long autoreId, String nomeEtichetta){
		return this.getRaccoltaByEtichettaAndAutore(autoreId, etichettaService.getEtichettaByNome(nomeEtichetta).getId());
	}
	
	public Raccolta saveNewRaccolta(Raccolta r){
		return this.raccoltaRepository.save(r);
	}

	public void deleteRaccolta(Long idRaccolta){
		this.raccoltaRepository.deleteById(idRaccolta);
	}

	public void updateRaccolta(Long id, String nome, String descrizione, String urlImage, String etichetta){
		Raccolta r = this.getRaccoltaById(id);
		r.setNome(nome);
		r.setDescrizione(descrizione);
		r.setUrlImage(urlImage);
		r.setEtichetta(etichettaService.getEtichettaByNome(etichetta));
		this.raccoltaRepository.save(r);
	}

}