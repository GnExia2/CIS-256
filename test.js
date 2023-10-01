function hashTable(key){
    let hashArray = [null, null, null, null, 92, 69, null, null, null, null, null]
    let hashKey = key;
    let hashCount=0;
    let hash1Key = key % 11;
    let hash2Key =  5 - key % 5;
    let tableSize = 11;

    for (i=0; i<hashArray.length; i++){
        let hashID = ((hash1Key) + i * hash2Key) % tableSize
        hashCount++
        for (let index = 0; index < hashArray.length; index++) {
            if (hashArray[hashID] == hashArray[i]){
                return hashCount
            }
            else {
                return null
            };
    
        }
    }

}

console.log(hashTable(69));