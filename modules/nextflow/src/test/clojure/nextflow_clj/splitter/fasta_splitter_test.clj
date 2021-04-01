(ns nextflow-clj.splitter.fasta-splitter-test)

(comment

  (ns nextflow-clj.splitter.fastaSplitterTest
    (:import (org.codehaus.groovy.runtime StringGroovyMethods)
             (nextflow.splitter FastaSplitter)
             (java.util Map)))




  (StringGroovyMethods/stripIndent

    "
    ;

    >gi|5524211|gb|AAD44166.1| cytochrome b
                               NLFVALYDFVASGDNTLSITKGEKLRVLGYNHNGEWCEAQTKNGQGWVPS
                               NYITPVN")



  (let [fasta (StringGroovyMethods/stripIndent

                "
                ;

                >gi|5524211|gb|AAD44166.1| cytochrome b
                                           NLFVALYDFVASGDNTLSITKGEKLRVLGYNHNGEWCEAQTKNGQGWVPS
                                           NYITPVN"

                )]

    (FastaSplitter/parseFastaRecord fasta))

  (Map "id" true)


  '())
