package it.uniroma3.theboys.quix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.theboys.quix.model.Raccolta;
import it.uniroma3.theboys.quix.repository.RaccoltaRepository;
import it.uniroma3.theboys.quix.repository.EtichettaRepository;

//classe per definire le operazioni CRUD tramite metodi java: descrive i servizi offerti
@Service
public class RaccoltaService {
	@Autowired
	private RaccoltaRepository raccoltaRepository;	//istanza costruita e inizializzata dal framework

	@Autowired EtichettaRepository etichettaRepository;

    public Raccolta getRaccoltaById(Long id) {
        return this.raccoltaRepository.findById(id).get();
    }

	public Iterable<Raccolta> getAllRaccolte(){
		return this.raccoltaRepository.findAll();
	}

	public Iterable<Raccolta> getRaccoltaByEtichetta(Long etichettaId){
		return this.raccoltaRepository.findRaccoltaByEtichettaId(etichettaId);
	}

	public Iterable<Raccolta> getRaccoltaByEtichettaAndAutore(Long autoreId, Long etichettaId){
		return this.raccoltaRepository.findRaccoltaByAutoreIdAndEtichettaId(autoreId, etichettaId);
	}

	public Iterable<Raccolta> getRaccoltaByEtichettaNomeAndAutore(Long autoreId, String nomeEtichetta){
		return this.getRaccoltaByEtichettaAndAutore(autoreId, etichettaRepository.findEtichettaByNome(nomeEtichetta).getId());
	}
	
	public Raccolta save(Raccolta r){
		return this.raccoltaRepository.save(r);
	}

}