package utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import com.google.gson.Gson;

public class LeitorMassaJson {
	// create Gson instance
	Gson gson = new Gson();
	Reader reader;
	Map<String, String> map;

	/**
	 * Grava arquivos jSon no diretorio correspondente
	 * @throws IOException
	 */
	public void gravaArquivoJson() throws IOException {
		FileWriter writer = new FileWriter("." + File.separator + "dadosTestes_copy.json");
		gson.toJson(map, writer);
		writer.flush();
		writer.close();
	}
/**
 * Faz a leitura de um Json.
 * @throws IOException
 */
	public void leitorJson() throws IOException {

		// Leitor do Java
		reader = new FileReader("." + File.separator + "dados_teste.json");

		// convert JSON file to map
		map = gson.fromJson(reader, Map.class);
		exibirmapJson(map);
		System.out.println(map.get("url"));

		// close reader
		reader.close();

	}
/**
 * Exibe todos os registros do Json Lido
 * @param map
 */
	public void exibirmapJson(Map<String, String> map) {
		// print map entries
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
	
public String getMassa(String chave) {
	return map.get(chave);

}

}
