package com.duoyi.gradle

class RobuMapUtils {
    private static final String MAP_SEPARATOR = ":"

    public static boolean notSame(Map map, String name, String hash) throws NoSuchMethodException{
        def notSame = false
        if (map) {
            def value = map.get(name)
            if (value) {
                if (!value.equals(hash)) {
                    notSame = true
                }
            } else {
                throw new NoSuchMethodException("Error：存在新增方法或对照表不匹配")
            }
        }
        return notSame
    }

    public static Map parseMap(File hashFile) {
        def hashMap = [:]
        if (hashFile.exists()) {
            hashFile.eachLine {
                List list = it.split(MAP_SEPARATOR)
                if (list.size() == 2) {
                    hashMap.put(list[0], list[1])
                }
            }
        } else {
            println "$hashFile does not exist"
        }
        return hashMap
    }

    public static format(String path, String hash) {
        return path + MAP_SEPARATOR + hash + "\n"
    }
}
