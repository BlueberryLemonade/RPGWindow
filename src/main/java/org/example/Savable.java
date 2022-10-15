package org.example;

import java.io.Externalizable;
import java.util.Collection;

interface Savable {

     void saveFile(Collection<Externalizable> saveData, String fileName);
     boolean fileExists(String path);

}
