REGISTER /opt/cloudera/parcels/CDH/lib/pig/piggybank.jar;
DEFINE RegexMatch org.apache.pig.piggybank.evaluation.string.RegexMatch();
keywords = LOAD 'class5/keywords.txt' AS (keyword: chararray);
lines = LOAD 'class5/input.txt' AS (line: chararray);
data = CROSS keywords, lines;
wordCounts = FOREACH data GENERATE keywords::keyword, RegexMatch(LOWER(lines::line), CONCAT('.*', LOWER(keywords::keyword), '.*'));
grouped_wordCounts = FOREACH (GROUP wordCounts BY keywords::keyword) GENERATE group, SUM(wordCounts.$1);
STORE (ORDER grouped_wordCounts BY $0) INTO 'class5/output';
