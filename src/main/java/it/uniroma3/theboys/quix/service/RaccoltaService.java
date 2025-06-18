package it.uniroma3.theboys.quix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public Iterable<Raccolta> getRaccoltaByEtichettaNome(String nomeEtichetta){
		return this.raccoltaRepository.findByEtichettaNome(nomeEtichetta);
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

	public void deleteRaccolta(Long id){
		this.raccoltaRepository.deleteAllRaccoltaId(id);
		this.raccoltaRepository.deleteById(id);
	}

	public void updateRaccolta(Long id, String nome, String descrizione, String urlImage, String etichetta){
		Raccolta r = this.getRaccoltaById(id);
		r.setNome(nome);
		r.setDescrizione(descrizione);
		r.setUrlImage(urlImage);
		r.setEtichetta(etichettaService.getEtichettaByNome(etichetta));
		this.raccoltaRepository.save(r);
	}

	public Long getNumeroRaccolteAutore(Long autoreId){
		return this.raccoltaRepository.countByAutoreId(autoreId);
	}

	public String getEtichettaPiuUsata(Long autoreId){
		List<Object[]> risultati = raccoltaRepository.findEtichettaNomeWithMaxCountByAutore(autoreId);
		if (!risultati.isEmpty()) {
			return (String) risultati.get(0)[0];
		}
		return "Nessuna etichetta trovata";
	}

	public String getEtichettaPiuGiocata(Long giocatoreId){
		List<Object[]> risultati = raccoltaRepository.findEtichettaNomeWithMaxCountByGiocatore(giocatoreId);
		if (!risultati.isEmpty()) {
			return (String) risultati.get(0)[0];
		}
		return "Nessuna etichetta trovata";
	}	

}