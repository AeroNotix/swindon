(ns swindon.core
  (:import [java.util.zip Deflater]
           [java.util.zip Inflater]
           [java.util.zip DeflaterInputStream]
           [java.util.zip DeflaterOutputStream]
           [java.util.zip InflaterInputStream]
           [java.io ByteArrayInputStream]
           [java.io ByteArrayOutputStream]))


(defn zip
  ([buffer]
     (zip buffer false))
  ([buffer wrap]
     (let [defl (Deflater. 3 wrap)
           bais (ByteArrayInputStream. buffer)
           dis (DeflaterInputStream. bais defl)
           baos (ByteArrayOutputStream.)]
       (org.apache.commons.io.IOUtils/copy dis baos)
    (.toByteArray baos))))

(defn unzip 
  ([buffer]
     (unzip buffer false))
  ([buffer wrap]
     (let [inf (Inflater. wrap)
           bais (ByteArrayInputStream. buffer)
           iis (InflaterInputStream. bais inf)
           baos (ByteArrayOutputStream.)]
       (org.apache.commons.io.IOUtils/copy iis baos)
       (.toByteArray baos))))

