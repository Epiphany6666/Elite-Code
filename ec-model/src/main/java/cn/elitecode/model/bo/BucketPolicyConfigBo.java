package cn.elitecode.model.bo;

import java.util.List;

public class BucketPolicyConfigBo {

    private String Version;
    private List<Statement> Statement;

    public BucketPolicyConfigBo(String Version, List<Statement> Statement) {
        this.Version = Version;
        this.Statement = Statement;
    }

    /**
     * 获取
     * @return Version
     */
    public String getVersion() {
        return Version;
    }

    /**
     * 设置
     * @param Version
     */
    public void setVersion(String Version) {
        this.Version = Version;
    }

    public String toString() {
        return "BucketPolicyConfigBo{Version = " + Version + ", Statement = " + Statement + "}";
    }

    public static class Statement {
        private String Effect;
        private String Principal;
        private String Action;
        private String Resource;

        public Statement(String Effect, String Principal, String Action, String Resource) {
            this.Effect = Effect;
            this.Principal = Principal;
            this.Action = Action;
            this.Resource = Resource;
        }

        public String toString() {
            return "Statement{Effect = " + Effect + ", Principal = " + Principal + ", Action = " + Action + ", Resource = " + Resource + "}";
        }
    }
}
