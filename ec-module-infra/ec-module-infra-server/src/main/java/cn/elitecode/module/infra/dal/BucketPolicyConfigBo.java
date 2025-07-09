package cn.elitecode.module.infra.dal;

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

    /**
     * 获取
     * @return Statement
     */
    public List<Statement> getStatement() {
        return Statement;
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

        /**
         * 获取
         * @return Effect
         */
        public String getEffect() {
            return Effect;
        }

        /**
         * 获取
         * @return Principal
         */
        public String getPrincipal() {
            return Principal;
        }

        /**
         * 获取
         * @return Action
         */
        public String getAction() {
            return Action;
        }

        /**
         * 获取
         * @return Resource
         */
        public String getResource() {
            return Resource;
        }
    }
}
