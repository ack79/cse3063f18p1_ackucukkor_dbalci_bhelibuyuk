from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.feature_extraction.text import CountVectorizer
import pandas as pd




class Frequency:

    def __init__(self, corpus):
        self.corpus = corpus

    def termFrequency(self):

        vec = CountVectorizer().fit(self.corpus)
        bag_of_words = vec.transform(self.corpus)
        sum_words = bag_of_words.sum(axis=0)
        words_freq = [(word, sum_words[0, idx]) for word, idx in vec.vocabulary_.items()]
        words_freq = sorted(words_freq, key=lambda x: x[1], reverse=True)
        return words_freq[:50]

    def idf(self):
        vectorizer = TfidfVectorizer()
        vectorizer.fit(self.corpus)

        df = pd.DataFrame(vectorizer.fit_transform(self.corpus).toarray(), columns=vectorizer.get_feature_names())
        frequentWord = self.termFrequency()
        df = df.to_dict()

        tfidf = {}

        for word in frequentWord:
            sum = 0
            for key, value in df.get(word[0]).items():
                sum = sum + value

            tfidf[word[0]] = sum

        return tfidf





