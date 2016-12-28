package www.lince.com.test.request;

import java.util.List;


public class GankEntity {

    /**
     * error : false
     * results : [{"_id":"58632374421aa9723d29b9ba","createdAt":"2016-12-28T10:29:08.507Z","desc":"12-28","publishedAt":"2016-12-28T11:57:39.616Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034gw1fb6aqccs3nj20u00u0wk4.jpg","used":true,"who":"daimajia"},{"_id":"5861d315421aa97240ef9f43","createdAt":"2016-12-27T10:33:57.376Z","desc":"12-27","publishedAt":"2016-12-27T12:06:15.638Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034gw1fb558z2peqj20u00u00v9.jpg","used":true,"who":"daimajia "},{"_id":"58606820421aa9723d29b9a1","createdAt":"2016-12-26T08:45:20.537Z","desc":"12-26","publishedAt":"2016-12-26T11:40:05.242Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1fb3whph0ilj20u00na405.jpg","used":true,"who":"daimajia"},{"_id":"585c9b32421aa9723a5a77b6","createdAt":"2016-12-23T11:34:10.86Z","desc":"12-23","publishedAt":"2016-12-23T11:41:19.908Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034gw1fb0kieivhgj20u00k2gmr.jpg","used":true,"who":"daimajia"},{"_id":"585b22cd421aa97240ef9f15","createdAt":"2016-12-22T08:48:13.828Z","desc":"12-22","publishedAt":"2016-12-22T11:34:37.39Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1faza3ghd2lj20f00k1gof.jpg","used":true,"who":"daimajia"},{"_id":"5859f7eb421aa9723a5a779d","createdAt":"2016-12-21T11:32:59.868Z","desc":"12-21","publishedAt":"2016-12-21T11:37:35.629Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034gw1fay98gt0ocj20u011hn24.jpg","used":true,"who":"代码家"},{"_id":"585870df421aa97237bca8ce","createdAt":"2016-12-20T07:44:31.343Z","desc":"12-20","publishedAt":"2016-12-20T11:48:13.616Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1fawx09uje2j20u00mh43f.jpg","used":true,"who":"代码家"},{"_id":"58569ab6421aa97237bca8c5","createdAt":"2016-12-18T22:18:30.807Z","desc":"12-18","publishedAt":"2016-12-19T11:57:16.232Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1favb116hm2j20u00u0gqi.jpg","used":true,"who":"daimajia"},{"_id":"585331db421aa9723d29b95c","createdAt":"2016-12-16T08:14:19.281Z","desc":"12-17","publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg","used":true,"who":"代码家"},{"_id":"585212b4421aa97240ef9ed7","createdAt":"2016-12-15T11:49:08.132Z","desc":"12-15","publishedAt":"2016-12-15T11:54:38.900Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1farbzjliclj20u00u076w.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 58632374421aa9723d29b9ba
         * createdAt : 2016-12-28T10:29:08.507Z
         * desc : 12-28
         * publishedAt : 2016-12-28T11:57:39.616Z
         * source : chrome
         * type : 福利
         * url : http://ww1.sinaimg.cn/large/610dc034gw1fb6aqccs3nj20u00u0wk4.jpg
         * used : true
         * who : daimajia
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
