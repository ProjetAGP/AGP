package lucene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import persistence.HotelData;
import persistence.TouristicSiteData;

//This class is used to test the indexing and search capability of lucene library.

public class LuceneTester {

	private String indexDir = "./index";
	private String dataDir = "./data/TOURISTIC_SITE";
	private Indexer indexer;
	private Searcher searcher;

	private List<String> resultsLucene = new ArrayList<String>();
	
	

	public LuceneTester(String KeyWord) {
		try {
			
			this.createIndex();
			this.search(KeyWord);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void createIndex() throws IOException {
		indexer = new Indexer(indexDir);
		int numIndexed;
		long startTime = System.currentTimeMillis();
		numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
		long endTime = System.currentTimeMillis();
		indexer.close();
		System.out.println(numIndexed + " File indexed, time taken: "
				+ (endTime - startTime) + " ms");
	}

	public void search(String searchQuery) throws IOException, ParseException {
		searcher = new Searcher(indexDir);
		long startTime = System.currentTimeMillis();
		TopDocs hits = searcher.search(searchQuery);
		long endTime = System.currentTimeMillis();

		System.out.println(hits.totalHits + " documents found. Time :"
				+ (endTime - startTime));
		for (ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = searcher.getDocument(scoreDoc);
			System.out.println(""
					+ doc.get(LuceneConstants.FILE_NAME).substring(0,
							doc.get(LuceneConstants.FILE_NAME).indexOf('.')));
			
			resultsLucene.add(""+doc.get(LuceneConstants.FILE_NAME).substring(0,doc.get(LuceneConstants.FILE_NAME).indexOf('.')));
		}
		searcher.close();
	}

	public List<String> getResultsLucene() {
		return resultsLucene;
	}

	public void setResultsLucene(List<String> results) {
		resultsLucene = results;
	}

	public String getIndexDir() {
		return indexDir;
	}

	public void setIndexDir(String indexDir) {
		this.indexDir = indexDir;
	}

	public String getDataDir() {
		return dataDir;
	}

	public void setDataDir(String dataDir) {
		this.dataDir = dataDir;
	}

	public Indexer getIndexer() {
		return indexer;
	}

	public void setIndexer(Indexer indexer) {
		this.indexer = indexer;
	}

	public Searcher getSearcher() {
		return searcher;
	}

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}
	
	

	
}
