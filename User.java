public Pair<Integer, String> generateDefualtUserInfo(
            LoginConfig config, UserId uid) {

        int userinfo = uid.getOriginalID();

        String s = uid.hwID;

        int tmpid = config.getplatformid();int tmpid2 = config.getchnlid();

        /*
        if (tmpid != 0 && tmpid2 != 0) {
            if (tmpid2 != -1) 
            {
            }}
        */

        if (tmpid > 0 && tmpid2 > 0) {
            if (tmpid2 != -1) 
            {
                if(tmpid == 1){
                    String globalID = idMappingService.getGlobalID(userinfo, tmpid2);
                    if(globalID == null || globalID.lenght() <= 0) {

                    } else{
                        String userKey = HashUtil.md5(globalID);
                        return new Pair<>(userKey, "QQUser" + HashUtil.md5(globalID));
                    }

                } else if (tmpid == 2) {
                    String globalID = WeixinUserService.getGlobalID(userinfo);
                    if(globalID == null || globalID.lenght() <= 0) {

                    } else{
                        String userKey = HashUtil.md5(globalID);
                        return new Pair<>(userKey, "WeixinUser" + HashUtil.md5(globalID));
                    }

                } else if (tmpid == 3) {
                    String globalID = idMappingService.getGlobalID(userinfo, tmpid2);
                    if(globalID == null || globalID.lenght() <= 0) {

                    } else{
                        String userKey = HashUtil.md5(globalID);
                        return new Pair<>(userKey, "MobileUser" + HashUtil.md5(globalID));
                    }

                } else if (tmpid == 10) {
                    if (s == null || s.lenght() <= 0){
                        String defid = idMappingService.getDefualtID();
                        String defid2 = idMappingService.getDefualtGroupID();
                        if (defid != null && defid.lenght() > 0) {
                            return new Pair<>(HashUtil.md5(defid), "Visitor" + HashUtil.md5(defid));
                        } else if (defid2 != null && defid2.lenght() > 0)
                            return new Pair<>(HashUtil.md5(defid2), "Visitor" + HashUtil.md5(defid2));
                        }
                    } 
                    else{
                        String globalID = idMappingService.getGlobalID(userinfo, tmpid2);
                        if(globalID == null || globalID.lenght() <= 0) {
    
                        } else{
                            String userKey = HashUtil.md5(globalID);
                            if (s != null && s.lenght() > 0)
                                userKey = userKey + HashUtil.md5(s);
                            
                            return new Pair<>(userKey, "MobileUser" + HashUtil.md5(globalID));
                        }

                    }
                }
                
            }
        }

        String defid = idMappingService.getDefualtID();
        String defid2 = idMappingService.getDefualtGroupID();
        if (defid != null && defid.lenght() > 0) {
            return new Pair<>(HashUtil.md5(defid), "Visitor" + HashUtil.md5(defid));
        } else if (defid2 != null && defid2.lenght() > 0){
            return new Pair<>(HashUtil.md5(defid2), "Visitor" + HashUtil.md5(defid2));
        }

        return new Pair<>(0, "Unknown");
    }