package lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

//This class is used to search the indexes created by Indexer to search the requested contents.
public class Searcher {
	
   IndexSearcher indexSearcher;
   QueryParser queryParser;
   Query query;
   
   @SuppressWarnings("deprecation")
public Searcher(String indexDirectoryPath) 
      throws IOException{
      Directory indexDirectory = 
         FSDirectory.open(new File(indexDirectoryPath));
      //Create a lucene directory which should point to location where indexes are to be stored.
      indexSearcher = new IndexSearcher(indexDirectory);
      /*Initialize the QueryParser object created with a standard analyzer
      having version information and index name on which this query is to run.*/
      queryParser = new QueryParser(Version.LUCENE_36,
         LuceneConstants.CONTENTS,
         new StandardAnalyzer(Version.LUCENE_36));
   }
   
   public TopDocs search( String searchQuery) 
      throws IOException, ParseException{
	   /*To start search, create a Query object by parsing search expression through QueryParser.
			Make search by calling IndexSearcher.search() method.*/
      query = queryParser.parse(searchQuery);
      return indexSearcher.search(query, LuceneConstants.MAX_SEARCH);
   }

   public Document getDocument(ScoreDoc scoreDoc) 
      throws CorruptIndexException, IOException{
      return indexSearcher.doc(scoreDoc.doc);	
   }

   public void close() throws IOException{
      indexSearcher.close();
   }
}