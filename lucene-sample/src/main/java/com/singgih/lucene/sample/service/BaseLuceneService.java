package com.singgih.lucene.sample.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;

import com.google.common.base.Stopwatch;
import com.singgih.lucene.sample.model.Indexable;
import com.singgih.lucene.sample.model.Result;
import com.singgih.lucene.sample.util.Constants;
import com.singgih.lucene.sample.util.IndexFactory;

public abstract class BaseLuceneService<T extends Indexable> {
	Logger log = Logger.getLogger("com.singgih.lucene");

	private Stopwatch stopwatch = null;

	protected void startTimer() {
		stopwatch = new Stopwatch().start();
	}

	protected long stopTimer() {
		long elapsedTime = stopwatch.elapsed(TimeUnit.MILLISECONDS);
		log.debug("Executed on : " + elapsedTime + " ms");
		return elapsedTime;
	}
	
	protected IndexSearcher getIndexSearcher() throws IOException{
		IndexReader reader = DirectoryReader.open(IndexFactory.getIndex());
		IndexSearcher searcher = new IndexSearcher(reader);
		return searcher;
	}
	
	protected void closeIndexSearcher(IndexSearcher indexSearcher) throws IOException{
		if(indexSearcher != null){
			indexSearcher.getIndexReader().close();
//			IndexFactory.getIndex().close();
		}
	}
	
	protected IndexWriter getIndexWriter() throws IOException{
		StandardAnalyzer analyzer = new StandardAnalyzer(Constants.LUCENE_VERSION);
		IndexWriterConfig config = new IndexWriterConfig(Constants.LUCENE_VERSION, analyzer);
		IndexWriter indexWriter = new IndexWriter(IndexFactory.getIndex(), config);
		return indexWriter;
	}

	protected void closeIndexWriter(IndexWriter indexWriter) throws IOException{
		if(indexWriter != null){
			indexWriter.close();
//			IndexFactory.getIndex().close();
		}
	}
	
	public void closeIndex() throws IOException{
		IndexFactory.getIndex().close();
	}
	
	public abstract Result<T> search(String category, String keyword) throws IOException, ParseException;
	public abstract void add(List<T> t) throws IOException;
	public abstract void add(T t) throws IOException; 
	public abstract void update(T book) throws IOException;
	public abstract void remove(T book) throws IOException;
}
