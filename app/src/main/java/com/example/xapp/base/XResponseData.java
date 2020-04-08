package com.example.xapp.base;

public class XResponseData {
    public static class GirlItems {
        private int ImgItems;

        public GirlItems(int ImgItems) {
            this.ImgItems = ImgItems;
        }

        public int getImgItems() {
            return ImgItems;
        }

        public void setImgItems(int imgItems) {
            ImgItems = imgItems;
        }
    }

    public static class GirlGroups {
        private int sFaces;
        private String gNickname;

        public GirlGroups(int sFaces, String gNickname) {
            this.sFaces = sFaces;
            this.gNickname = gNickname;
        }

        public int getsFaces() {
            return sFaces;
        }

        public void setsFaces(int sFaces) {
            this.sFaces = sFaces;
        }

        public String getgNickname() {
            return gNickname;
        }

        public void setgNickname(String gNickname) {
            this.gNickname = gNickname;
        }
    }
}
