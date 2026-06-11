class Researcher extends Regular {
    public Researcher(int id, String name, char grade, char ho) { super(id, name, grade, ho); }
    public int pay() { return salary + 300000; } // 기본급 + 연구수당
    public String type() { return "연구직"; }
    public int getResearchAllowance() { return 300000; }
}